let student = {
    name: "Amudesh",
    age: 21,
    grade: "A",
    displayInfo: function() {
        console.log(`Name: ${this.name}, Age: ${this.age}, Grade: ${this.grade}`);
    }
};
console.log(student.name);
console.log(student.age);
console.log(student.grade);
student.displayInfo();
student.address = {
    street: "123 Main St",
    city: "Ariyalur",
    country: "India",
    displayAddress: function() {
        console.log(`Address: ${this.street}, ${this.city}, ${this.country}`);
    },
    updateAddress: function(street, city, country) {
        this.street = street;
        this.city = city;
        this.country = country;
        console.log("Address updated!");
    }
};
console.log(student.address.street);
console.log(student.address.city);
console.log(student.address.country);
student.address.displayAddress();
student.address.updateAddress("456 ", "Tiruchy", "India");
student.address.displayAddress();
delete student.grade;
delete student.displayInfo;
console.log(student);
