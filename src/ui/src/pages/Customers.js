const customers = [ {
    "customerId": 1,
    "firstName": "Cally",
    "lastNAme": "Reynolds",
    "emailAddress": "penatibus.et@lectusa.com",
    "phoneNumber": "(901) 166-8355",
    "address": "556 Lakewood Park, Bismarck, ND 58505"
},
    {
        "customerId": 2,
        "firstName": "Sydney",
        "lastNAme": "Bartlett",
        "emailAddress": "nibh@ultricesposuere.edu",
        "phoneNumber": "(982) 231-7357",
        "address": "4829 Badeau Parkway, Chattanooga, TN 37405"
    }]

const Customers = () => {
    return (
        <table>
            <thread>
                <th>ID</th>
                <th>First Name</th>
                <th>LastName</th>
                <th>Email Address</th>
                <th>Phone Number</th>
                <th>Address</th>
            </thread>
            <tbody>
            {customers.map(customer => {
                const {
                    customerId,
                    firstName,
                    lastName,
                    emailAddress,
                    phoneNumber,
                    address
                } = customer;
                return (
                <tr key={customerId}>
                    <td>{custtomerId}</td>
                    <td>{firstName}</td>
                    <td>{lastName}</td>
                    <td>{emailAddress}</td>
                    <td>{phoneNumber}</td>
                    <td>{address}</td>
                </tr>
                )
            })}
            </tbody>
        </table>
    )
};

export default Customers;