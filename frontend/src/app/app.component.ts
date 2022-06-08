import { Component } from '@angular/core';
import { Client } from './client';
import { ClientService } from './client.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'frontend';
  id!: number;
  lastName!: string;
  firstName!: string;
  address!: string;
  city!: string;
  zipCode!: string;

  // Resultat requête
  clients!: Client[];
  
  constructor(private clientService: ClientService) {}

  findClient() {

    if(this.lastName == null) {
      this.lastName = "";
    }
    if(this.firstName == null) {
      this.firstName = "";
     }
    if(this.address == null) {
      this.address = "";
    }
    if(this.city == null) {
      this.city = "";
    }
    if(this.zipCode == null) {
      this.zipCode = "";
    }

    this.clientService.getClientWithAllParams(this.lastName, this.firstName, this.address, this.city, this.zipCode).subscribe({
      next: (clients: Client[]) => this.clients = clients,
      error: (err) => console.log(err)
    });
  }
}

