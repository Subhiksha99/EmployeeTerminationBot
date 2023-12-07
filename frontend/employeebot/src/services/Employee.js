class Employee {
    emp = {}
    addEmployee(user) {
        this.emp = user;
        console.log(this.emp);
    }
}

export default new Employee();