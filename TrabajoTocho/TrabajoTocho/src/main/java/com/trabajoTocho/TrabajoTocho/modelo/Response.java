package com.trabajoTocho.TrabajoTocho.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Response")
public class Response
    /*Tener en cuenta que en esta clase tengo que poner como clave foránea el id del usuario
    * y además, voy a tener que añadir el id de la publicación ya que tengo que tener en cuenta
    * que se trata de una tabla de muchos a muchos*/
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_response;

}
