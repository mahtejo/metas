package unidade;

import base.AbstractTest;
import models.Meta;
import models.dao.GenericDAO;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MetaTest extends AbstractTest{


    GenericDAO dao = new GenericDAO();

    List<Meta> metas;

    @Test
    public void deveIniciarBDVazio() {
        metas = dao.findAllByClass(Meta.class);
        assertThat(metas.size()).isEqualTo(0);
    }

    @Test
    public void deveAdicionarMeta() throws Exception {
        Meta m1 = new Meta("Fazer o lab 2", 2, "concluir o lab", "Alta");
        dao.persist(m1);

        metas = dao.findAllByClass(Meta.class); //consulta o bd
        assertThat(metas.size()).isEqualTo(1);
        assertThat(metas.get(0).getDescricao()).isEqualTo("concluir o lab");
    }

    @Test
    public void deveAlcancarMeta() throws Exception {
        Meta m1 = new Meta("Fazer o lab 2", 2, "concluir o lab", "Alta");
        dao.persist(m1);

        metas = dao.findAllByClass(Meta.class);

        assertFalse(metas.get(0).isAlcancada());

        metas.get(0).setAlcancada(true);

        assertTrue(metas.get(0).isAlcancada());
    }

    @Test
    public void deveOrdenarMetas() throws Exception {
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

        metas = dao.findAllByClass(Meta.class);

        Collections.sort(metas);

        assertThat(metas.get(0).getDescricao()).isEqualTo("Mamãe pediu pra lavar, não posso deixar pra depois ://");
        assertThat(metas.get(1).getDescricao()).isEqualTo("Ultima prova do ano!!!!!");
        assertThat(metas.get(2).getDescricao()).isEqualTo("Comprei todos os livros e ainda não li!");
        assertThat(metas.get(3).getDescricao()).isEqualTo("Dedicar um tempo para o namorado, porque você tá muito ausente");
        assertThat(metas.get(4).getDescricao()).isEqualTo("concluir o lab");
        assertThat(metas.get(5).getDescricao()).isEqualTo("Porque também temos que ter tempo para lazer");
        assertThat(metas.get(6).getDescricao()).isEqualTo("concluir o lab");
        assertThat(metas.get(7).getDescricao()).isEqualTo("Partiu CSF o//");
        assertThat(metas.get(8).getDescricao()).isEqualTo("Tentar conseguir pontos de esculhabação para pagar LOAC!!!");
        assertThat(metas.get(9).getDescricao()).isEqualTo("Partiu assistir ep novo :)");

    }
}