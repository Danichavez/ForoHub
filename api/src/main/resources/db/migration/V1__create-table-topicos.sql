CREATE TABLE usuarios(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100)  NULL,
    contraseña VARCHAR(100) NOT NULL,
    perfiles VARCHAR(50) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE cursos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria varchar(100)
);

CREATE TABLE topicos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    idusuario BIGINT NOT NULL,
    idcurso BIGINT NOT NULL,
    FOREIGN KEY (idusuario) REFERENCES usuarios(id),
    FOREIGN KEY (idcurso) REFERENCES cursos(id)
);


CREATE TABLE perfiles(
    id BIGINT NOT NULL auto_increment,
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuarioperfil(
    id BIGINT NOT NULL auto_increment primary key,
    idperfil BIGINT NOT NULL,
    idusuario BIGINT NOT NULL,
    FOREIGN KEY (idusuario) REFERENCES usuarios(id),
    FOREIGN KEY (idperfil) REFERENCES perfiles(id)
);



