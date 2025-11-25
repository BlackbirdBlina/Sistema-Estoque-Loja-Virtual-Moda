package main.com.sistema.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Etiqueta {
    String marca();
    String paisOrigem();
}
