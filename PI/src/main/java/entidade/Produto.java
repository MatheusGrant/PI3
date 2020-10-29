package entidade;
public class Produto {
    
    private String nome;
    private int cod;
    private double preço;
    private String validade;

    
    public Produto(String nome, int cpf_cliente, double cod, String validade){
        
        this.nome = nome;
        this.cod = cpf_cliente;
        this.preço = cod;
        this.validade = validade;

        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }


    }

   
    

