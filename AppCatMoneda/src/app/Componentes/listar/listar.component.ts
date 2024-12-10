import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WsCatMonedaService } from '../../Servicios/ws-cat-moneda.service';
import { CatMoneda } from '../../Entidades/CatMoneda';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css'
})
export class ListarComponent implements OnInit{
  ngOnInit(){
    this.listar();
  }
  
  constructor(private router: Router, private service: WsCatMonedaService){}

  listado!: CatMoneda[];

  listar(){
    this.service.listar().subscribe({
      next: data => {
        this.listado = data;
      },
      error: error =>{
        console.error(JSON.stringify(error));

        Swal.fire({
          title: "Error",
          text: "Ocurrio un error al recuperrar la informacion",
          icon: "error",
          confirmButtonText: "OK"
        })
      }
    })
  }

  editar(catmoneda: CatMoneda){
    sessionStorage.setItem('idCliente',catmoneda.numCia.toString());
    this.router.navigate(['editar']);
  }

  eliminar(catMoneda: CatMoneda){
    let idCatMoneda = catMoneda.numCia;
    Swal.fire({
      title:'¿Estas seguro?',
      text: 'Si eliminas el alumno, no se podra recuperar',
      icon:'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor:'#d33',
      confirmButtonText:'Si, eliminalo',
     }).then((result) => {
      if(result.isConfirmed){
        this.service.eliminar(idCatMoneda).subscribe((data)=> {
          Swal.fire({
            title: 'Se elimino correctamente el alumno',
            icon:'success',
            showCancelButton: false,
            timer: 1500
          });
          this.listar();
        });
      }
     });
    }
}
