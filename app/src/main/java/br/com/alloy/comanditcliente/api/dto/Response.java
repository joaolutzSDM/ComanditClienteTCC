package br.com.alloy.comanditcliente.api.dto;

public class Response<T> {

    private int status;
    private String mensagem;
    private String sql;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", mensagem='" + mensagem + '\'' +
                ", sql='" + sql + '\'' +
                ", data=" + data +
                '}';
    }

}
