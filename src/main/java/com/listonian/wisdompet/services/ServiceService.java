package com.listonian.wisdompet.services;


import com.listonian.wisdompet.data.entities.ServiceEntity;
import com.listonian.wisdompet.data.repositories.ServiceRepository;
import com.listonian.wisdompet.web.errors.NotFoundException;
import com.listonian.wisdompet.web.models.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository serviceRepository;
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAllServicess(){
        Iterable<ServiceEntity> serviceEntities = this.serviceRepository.findAll();
        List<Service> services = new ArrayList<>();
        serviceEntities.forEach(serviceEntity->{
            services.add(this.translateDbToWeb(serviceEntity));
        });
        return services;
    }

    public Service getService(long id){
        Optional<ServiceEntity> optional = this.serviceRepository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundException("customer not found with id");
        }
        return this.translateDbToWeb(optional.get());
    }

    public Service createOrUpdate(Service service){
        ServiceEntity entity = this.translateWebToDb((service));
        entity = this.serviceRepository.save(entity);
        return this.translateDbToWeb(entity);
    }

    public void deleteService(long id){
        this.serviceRepository.deleteById(id);
    }

    private ServiceEntity translateWebToDb(Service service){
        ServiceEntity entity = new ServiceEntity();
        entity.setId(service.serviceId);
        entity.setName(service.getName());
        entity.setPrice(service.getPrice());
        return entity;
    }

    private Service translateDbToWeb(ServiceEntity entity){
        return new Service(entity.getId(), entity.getName(), entity.getPrice());
    }
}
