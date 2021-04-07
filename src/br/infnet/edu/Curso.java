package br.infnet.edu;

public class Curso {

    String codCurso;
    String curso;
    int capacidade;

    public Curso(String codCurso, String curso, int capacidade) {
        this.codCurso = codCurso;
        this.curso = curso;
        this.capacidade = capacidade;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
