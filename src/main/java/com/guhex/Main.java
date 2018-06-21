package com.guhex;

import com.guhex.hibernate.HibernateUtil;
import com.guhex.modelo.Usuario;
import com.guhex.service.ServiceGeneric;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Main {
    public static void main(String[] args) {
        Spark.staticFileLocation("/public/");
        enableDebugScreen();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates/");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        //Usuario por defecto
        Usuario usuario = new Usuario();
        usuario.setUsername("admin");
        usuario.setPassword("admin");

        new ServiceGeneric<Usuario>(Usuario.class).insert(usuario);

        get("/inicio", (req, resp) -> {
            Map<String, Object> attributes = new HashMap<>();

            attributes.put("usuarios", new ServiceGeneric<Usuario>(Usuario.class).findAll());

            return new ModelAndView(attributes, "/inicio.ftl");
        }, freeMarkerEngine);
    }
}
