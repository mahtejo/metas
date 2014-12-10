import models.Meta;
import models.dao.GenericDAO;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;

import java.util.List;

public class Global extends GlobalSettings {

    private static GenericDAO dao = new GenericDAO();

    @Override
    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");

        JPA.withTransaction(new play.libs.F.Callback0() {
            @Override
            public void invoke() throws Throwable {
                Meta meta1 = new Meta("Fazer o lab 2", 2, "concluir o lab", "Alta");
                Meta meta2 = new Meta("Assistir AHS", 3, "Partiu assistir ep novo :)", "Baixa");
                Meta meta3 = new Meta("Lavar os pratos", 1, "Mamãe pediu pra lavar, não posso deixar pra depois ://", "Alta");
                Meta meta4 = new Meta("Ler as Crônicas de Gelo e Fogo", 1, "Comprei todos os livros e ainda não li!", "Média");
                Meta meta5 = new Meta("Namorar mais", 2, "Dedicar um tempo para o namorado, porque você tá muito ausente", "Alta");
                Meta meta6 = new Meta("Verificar se o TOA já chegou", 3, "Partiu CSF o//", "Alta");
                Meta meta7 = new Meta("Estudar Linear", 1, "Ultima prova do ano!!!!!", "Alta");
                Meta meta8 = new Meta("Fazer um social no shopping", 2, "Porque também temos que ter tempo para lazer", "Baixa");
                Meta meta9 = new Meta("Fazer a atividade de Joseana", 3, "concluir o lab", "Alta");
                Meta meta10 = new Meta("Desentoutar as pelninhas dos Chips do Labarc", 3, "Tentar conseguir pontos de esculhabação para pagar LOAC!!!", "Alta");

                meta9.setAlcancada(true);
                meta6.setAlcancada(true);

                dao.persist(meta1);
                dao.persist(meta2);
                dao.persist(meta3);
                dao.persist(meta4);
                dao.persist(meta5);
                dao.persist(meta6);
                dao.persist(meta7);
                dao.persist(meta8);
                dao.persist(meta9);
                dao.persist(meta10);

                dao.flush();
            }
        });
    }

    @Override
    public void onStop(Application app){
        JPA.withTransaction(new play.libs.F.Callback0() {
            @Override
            public void invoke() throws Throwable {
                Logger.info("Aplicação finalizada...");
                List<Meta> metas = dao.findAllByClass(Meta.class);

                for (Meta meta : metas) {
                    dao.removeById(Meta.class, meta.getId());
                }
            }});
    }
}
