package entities;

public class Aluno {

        private String nome, dataNascimento, responsavel, endereco, telefone;
        private int idade, serie;
    
       public Aluno(String nome, String dataNascimento, String responsavel, String endereco, String telefone , int idade, int serie){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.responsavel = responsavel;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idade = idade;
        this.serie = serie;
       }
    
       public String getNome(){
            return nome;
       }
    
       public String getDataNascimento(){
        return dataNascimento;
    }
    
    public String getResponsavel(){
        return responsavel ;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public int getIdade(int idade){
        return idade;
    }
    
    public int getSerie(int serie){
        return serie;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setSerie(int serie) {
        this.serie = serie;
    }
    
}