package com.JWT.Util;// classe que vai gerar o JWT

public class JWTGenerator {
    public static void main(String[] args) {
        // Jwt trafega dados no formato json, por isso vai receber um objeto Json

        String header = "{\"alg\": \"HS256\"}";
        //alg = (algoritmo) : HmacSha256 (tipo de algoritmo)

        String payload = "{ \"nome\": \"JV\", \"admin\": true }";
        // 2 claims, (nome : João) e (admin: true)

        //começando a formar o nosso token

        String secret = "sexta-feira 13"; //meu secret do signature

        String encodeData = Base64Url.encode(header) + "."  //+ Base64Url.encode(payload);
        //Base64 é um metodo de codificação de dados para transferencia para net
        //encoda a minha header // Sout(encodeData); (mostra o encode)

        + Base64Url.encode(payload);
        //encoda o payload

        //tipo var = algoritmo . sign(secret, header+payload (data))
        String signature = HmacSha256.sign("sexta-feira 13", encodeData);
        //HmacSha256 foi o algoritmo do header (que também é a classe)

        String jwt = encodeData + "." + signature;
        // jwt = header+payload+siganture (não fazer, isso colocaa String do json no JWT, sem encodar)
        //System.out.println(jwt);




    }
}
