/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author bruuh
 */
public class Post {
    private Long id;
    private String titulo;
    private String subtitulo;
    private String texto;
    private Long usuarioID;
    private String img;
    private String video;

    public Post() {
        
    }
    
    public Post(String titulo,String subtitulo, String texto, Long usuarioID) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.texto = texto;
        this.usuarioID = usuarioID;
    }
    
    public Post(String titulo,String subtitulo, String texto, String imagem, String video, Long usuarioID) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.texto = texto;
        this.usuarioID = usuarioID;
        this.img = imagem;
        this.video = video;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the subtitulo
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * @param subtitulo the subtitulo to set
     */
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the getUsuarioID
     */
    public Long getUsuarioID() {
        return usuarioID;
    }

    /**
     * @param usuarioID the usuarioID to set
     */
    public void setUsuarioID(Long usuarioID) {
        this.usuarioID = usuarioID;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Post[ id=" + id + " ]";
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }
    
    /**
     * @return the video
     */
    public String getVideo() {
        return video;
    }

    /**
     * @param video the img to set
     */
    public void setVideo(String video) {
        this.video = video;
    }
    
    
}
