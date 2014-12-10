import models.Meta;
import org.junit.Assert;
import org.junit.Test;

public class ClasseMetaTest {

    @Test
    public void testaGetsESets(){

        try{
            Meta meta = new Meta("Fazer o lab 2", 2, "concluir o lab", "Alta");
            Assert.assertEquals(meta.getDescricao(), "concluir o lab");
            Assert.assertTrue(meta.getPrioridade().equals("Alta"));
            Assert.assertTrue(meta.getSemana() == 2);
            Assert.assertFalse(meta.isAlcancada());

            meta.setAlcancada(true);

            Assert.assertTrue(meta.isAlcancada());
        } catch (Exception e){
            Assert.fail();
        }
    }

}
