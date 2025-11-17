package com.trabajoTocho.TrabajoTocho.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Response")
public class Response
    /*Tener en cuenta que en esta clase tengo que poner como clave foránea el id del usuario
    * y además, voy a tener que añadir el id de la publicación ya que tengo que tener en cuenta
    * que se trata de una tabla de muchos a muchos*/
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @ManyToOne
    @JoinColumn(name = "post_uuid")
    @JsonBackReference
    private Post post;

    @Column
    private String description;

    @Column
    private String time;

    public Response(){}
    public Response(Post post, String des, String ti){
        this.post = post;
        this.description = des;
        this.time = ti;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(uuid, response.uuid) && Objects.equals(post, response.post) && Objects.equals(description, response.description) && Objects.equals(time, response.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, post, description, time);
    }


    @Override
    public String toString() {
        return "Response{" +
                "uuid=" + uuid +
                ", post=" + post +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
