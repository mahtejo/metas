package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Meta")
public class Meta implements Serializable, Comparable<Meta>{

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String descricao;
    @Column
    private int semana;
    @Column
    private String nomeMeta;
    @Column
    private String prioridade;
    @Column
    private boolean alcancada;

    public Meta (String nome, int prazo, String descricao, String prioridade){
        try {
            setDescricao(descricao);
            setSemana(prazo);
            setPrioridade(prioridade);
        } catch (Exception e) {
        }
        nomeMeta = nome;
        setAlcancada(false);
    }

    public Meta(){

    }

    public String getNome() {
        return nomeMeta;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) throws Exception{
        if(semana < 0 || semana > 4)
            throw new Exception("Um mês só pode ter 4 semanas!");
        this.semana = semana;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) throws Exception{
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception{
        if (descricao.length() == 0){
            throw new Exception("Descrição não deve ser vazia!");
        }
        this.descricao = descricao;
    }

    public boolean isAlcancada() {
        return alcancada;
    }

    public void setAlcancada(boolean alcancada) {
        this.alcancada = alcancada;
    }

    //As metas estão ordenadas pela semana em que planejei cumpri-las, e, em seguida, por prioridade.
    @Override
    public int compareTo(Meta meta) {

        int comparacao1 = this.getSemana() - meta.getSemana();

        if (comparacao1 == 0) {
            if (meta.getPrioridade().equals("Alta") && this.getPrioridade().equals("Baixa") || meta.getPrioridade().equals("Alta") && this.getPrioridade().equals("Média") ||
                    meta.getPrioridade().equals("Média") && this.getPrioridade().equals("Baixa"))
                return 1;

            if (this.getPrioridade().equals("Alta") && meta.getPrioridade().equals("Baixa") || this.getPrioridade().equals("Alta") && meta.getPrioridade().equals("Média") ||
                    this.getPrioridade().equals("Média") && meta.getPrioridade().equals("Baixa"))
                return -1;
            else {
                return this.getDescricao().compareTo(meta.getDescricao());
            }
        }
        return comparacao1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}