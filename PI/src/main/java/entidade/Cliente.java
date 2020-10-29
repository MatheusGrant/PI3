package entidade;
public class Cliente {
    
    private String nome;
    private String cpf_cliente;
    private String telefone;
    private String data_nasc;
    private String endereco;
    private String sexo;
    
    public Cliente(String nome, String cpf_cliente, String telefone, String data_nasc, String endereco, String sexo){
        
        this.nome = nome;
        this.cpf_cliente = cpf_cliente;
        this.telefone = telefone;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.sexo = sexo;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf_cliente=" + cpf_cliente + ", telefone=" + telefone + 
                ", data_nasc=" + data_nasc + ", endereco=" + endereco + ", sexo=" + sexo + '}';
    }

   
    
}