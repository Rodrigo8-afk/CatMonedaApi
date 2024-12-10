import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CatMoneda } from '../Entidades/CatMoneda';

@Injectable({
  providedIn: 'root'
})
export class WsCatMonedaService {

  url = 'http://localhost:8080/v1/api/catMoneda';


  constructor(private http: HttpClient) {}

    //Declaracion de los metodos para consumir los controladores del BackEnd
    listar(){
      return this.http.get<CatMoneda[]>(this.url);
    }

    guardar(catMoneda: CatMoneda){
      return this.http.post(this.url, catMoneda);
    }

    eliminar(idCatMoneda: number){
      return this.http.delete(this.url+"/"+idCatMoneda);
    }
    
    buscar(idCatMoneda: number){
      return this.http.get<CatMoneda>(this.url+"/"+idCatMoneda);
    }

    editar(catMoneda: CatMoneda){
      return this.http.put(this.url+"/"+catMoneda.numCia,catMoneda);
    }
}
