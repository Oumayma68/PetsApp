export class UserInfo {
    FirstName: string;
    LastName: string;
    Email: string;
    Password: string;

    constructor(firstname: string, lastname: string, email: string, password: string) {
    
        this.Email=email;
        this.FirstName=firstname;
        this.LastName=lastname;
        this.Password=password;
    }
}
