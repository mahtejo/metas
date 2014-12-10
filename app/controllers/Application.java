package controllers;

import models.Meta;
import models.dao.GenericDAO;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Collections;
import java.util.List;

public class Application extends Controller {

    private static Form<Meta> metaForm = Form.form(Meta.class);
    private static final GenericDAO dao = new GenericDAO();


    @Transactional
    public static Result metas() {
        List<Meta> result = dao.findAllByClass(Meta.class);
        Collections.sort(result);
        return ok(views.html.index.render(result));
    }

    @Transactional
    public static Result index() {
        return metas();
    }

    @Transactional
    public static Result novaMeta() {
        DynamicForm form = Form.form().bindFromRequest();

        if (form.hasErrors()) {
            List<Meta> result = dao.findAllByClass(Meta.class);
            Collections.sort(result);
            return badRequest(views.html.index.render(result));
        } else {

            String nome = form.get("nome");
            int prazo = Integer.parseInt(form.get("prazo"));
            String prioridade = form.get("prioridade");
            String descricao = form.get("descricao");

            Logger.debug("Criando meta: " + nome);

            Meta meta = new Meta(nome, prazo, descricao, prioridade);

            dao.persist(meta);

            dao.flush();

            return metas();
        }
    }

    @Transactional
    public static Result deleteMetas(long id) {
        dao.removeById(Meta.class, id);
        dao.flush();
        return metas();
    }

    @Transactional
    public static Result alcancarMeta(long id) {

        Form<Meta> filledForm = metaForm.bindFromRequest();

        if (filledForm.hasErrors()) {
            List<Meta> result = dao.findAllByClass(Meta.class);

            return badRequest(views.html.index.render(result));
        } else {
            Meta meta = dao.findByEntityId(Meta.class, id);
            meta.setAlcancada(true);
            Logger.debug("Deletando meta: " + filledForm.data().toString() + " como " + meta.getDescricao());

            dao.merge(meta);

            dao.flush();

            return metas();
        }
    }
}
