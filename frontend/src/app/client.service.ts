import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Client } from './client';
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: "root"
})

export class ClientService {

    private apiServerUrl = "http://localhost:8080/api/v1/clients";

    constructor(private http: HttpClient) { }

    public getClients(): Observable<Client[]> {
        return this.http.get<Client[]>(this.apiServerUrl);
    }

    public getClientById(id: number): Observable<Client> {
        return this.http.get<Client>(this.apiServerUrl + '/' + id);
    }

    public getClientWithAllParams(lastName: string, firstName: string, address: string, city: string, zipCode: string): Observable<Client[]> {
        return this.http.get<Client[]>(this.apiServerUrl, {
            params: {
                lastName: lastName,
                firstName: firstName,
                address: address,
                city: city,
                zipCode: zipCode
            }
        });
    }

}
