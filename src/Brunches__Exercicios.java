package src;

import java.util.Scanner;

public class Brunches__Exercicios {
    public static void main(String[]args) {
        int idade;
        Scanner scId = new Scanner(System.in);
        System.out.print("Idade: ");
        idade = scId.nextInt();

        if (idade<0){
            System.out.print("Idade Invalida!");
        }else if(idade<13){
            System.out.print("Criança");
            System.out.println(" ----> Valor da Hospedagem: 75,00 R$");
        }else if(idade<18){
            System.out.print("Adolescente");
            System.out.println(" ----> Valor da Hospedagem: 100,00 R$");
        }else if(idade<60){
            System.out.print("Adulto");
            System.out.println(" ----> Valor da Hospedagem: 150,00 R$");
        }else{
            System.out.print("Idoso");
            System.out.println(" ----> Valor da Hospedagem: 75,00 R$");
        }
    }
}