let StudentInfo = {
    id: 10,
    name: "Amudesh",
    department: "ECE",
    college: "Panimalar",
    email: "Amudesh@gmail.com",
}
    StudentInfo.AllInfo=function() {
        console.log("Student Details:");
        console.log("ID:", this.id);
        console.log("Name:", this.name);
        console.log("Department:", this.department);
        console.log("College:", this.college);
        console.log("Email:", this.email);
        console.log("Address:", this.address.doorNo, this.address.street, this.address.area, this.address.pincode);
    }

    StudentInfo.BasicInfo=function() {
        console.log("Basic Details:");
        console.log("ID:", this.id);
        console.log("Name:", this.name);
        console.log("Email:", this.email);
    }
    StudentInfo.address= {
        doorNo: "NO 5",
        street: "Car St",
        area: "Ariyalur",
        pincode: "123456"
    };
    StudentInfo.AddressInfo= function() {
        console.log("Student with Address Details:");
        console.log("ID:", this.id);
        console.log("Name:", this.name);
        console.log("Address:", this.address.doorNo, this.address.street, this.address.area, this.address.pincode);
    }

console.log("Display All Details:");
StudentInfo.AllInfo();
console.log("Display Basic Details:");
StudentInfo.BasicInfo();
console.log("Display Address Details:");
StudentInfo.AddressInfo();

delete StudentInfo.email;
delete StudentInfo.BasicInfo;

console.log("After Deleting email,Basic Details function:");
console.log(StudentInfo);
