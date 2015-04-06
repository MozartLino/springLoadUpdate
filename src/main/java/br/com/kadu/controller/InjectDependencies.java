package br.com.kadu.controller;

import br.com.kadu.model.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.annotation.Annotation;

@Aspect
public class InjectDependencies {

    @Autowired
    private HttpServletRequest request;

    @Around("execution(* br.com.kadu.controller.ProdutoController.salvar(..))")
    public void resolve(ProceedingJoinPoint joinPoint) throws Throwable {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            reader.close();
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Annotation[][] annotations = joinPoint.getTarget().getClass().getMethod(methodName,parameterTypes).getParameterAnnotations();

        System.out.println(joinPoint.getArgs()[0].getClass());
        Object[] args = joinPoint.getArgs();

        args[0] = update(sb.toString());

        joinPoint.proceed(args);


        System.out.println("******");
    }

    public Produto getProduto(){
        Produto produto = new Produto("nome", "descricao");
        produto.setId(1L);

        return produto;
    }


    private Produto update(String produto) throws IOException {
        return new ObjectMapper().readerForUpdating(getProduto()).readValue(produto);
    }
}