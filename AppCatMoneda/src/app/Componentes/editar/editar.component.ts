import { Component, OnInit } from '@angular/core';
import { WsCatMonedaService } from '../../Servicios/ws-cat-moneda.service';
import { Router } from '@angular/router';
import { CatMoneda } from '../../Entidades/CatMoneda';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './editar.component.html',
  styleUrl: './editar.component.css'
})
export class EditarComponent implements OnInit{
  ngOnInit(): void{
    this.buscar();
  }

  constructor(private service: WsCatMonedaService,
    private router: Router
 ){}
 catMoneda: CatMoneda = new CatMoneda();

  buscar(){
    let id = Number (sessionStorage.getItem('idCliente'));
 
    this.service.buscar(id).subscribe({
      next: (data)=>{
        this.catMoneda= data;
        console.log(data);
        Swal.fire({
          text: "Informacion recuperada con exito",
          icon:'success',
          showConfirmButton: false,
          timer: 1500
        });
      },
      error: (errorBuscar)=>{
        Swal.fire({
          text: "Error al buscar la informacion",
          icon:'error',
          confirmButtonText: 'OK'
        });
        this.router.navigate(['listar'])
      }
    });
  }
  editar(){
    this.service.editar(this.catMoneda).subscribe(data=>{
      Swal.fire({
        title: "Se edito correctamente la informacion",
        icon:"success",
        showConfirmButton: false,
        
        showClass: {
          popup: `
            animate__animated
            animate__fadeInUp
            animate__faster
          `
        },
        hideClass: {
          popup: `
            animate__animated
            animate__fadeOutDown
            animate__faster
          `
        },
        timer: 2000
      });
      this.router.navigate(['listar']);
    });
  }
}
