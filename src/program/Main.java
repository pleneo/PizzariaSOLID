package program;


import entities.*;
import entities.services.MakeOrder;
import entities.services.customer.FileCustomerRepository;
import entities.services.menu.FileMenuRepository;
import entities.services.pizzaria.FilePizzariaRepository;
import exceptions.OutOfIndexBoundsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static entities.services.MakeOrder.makeOrder;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        FileMenuRepository fmr = new FileMenuRepository();
        FilePizzariaRepository fpr = new FilePizzariaRepository();
        FileCustomerRepository fcr = new FileCustomerRepository();
        Pizzaria pizzaria = null;


        System.out.println("CRIE O CARDÁPIO DAS PIZZARIAS: ");
        int index = -1;
        while(index != 0 ){
            System.out.println("OPÇÕES DE CRIAÇÃO DO CARDÁPIO: ");
            System.out.println("\n1. Visualizar Cardápio");
            System.out.println("2. Adicionar Produto");

            System.out.println("\n0. Sair");

            try{
                index = sc.nextInt();
                System.out.println();
                if(index<0 || index > 2) throw new OutOfIndexBoundsException();

                if(index == 1){
                    List<Product> products  =new ArrayList<>();

                    products = fmr.getProducts();

                    for(int i=0; i<products.size(); i++){
                        Product p = products.get(i);
                        String category = (p.getCategory() == 1) ? "PIZZA" : ((p.getCategory() == 2) ? "BEBIDA" : "NULL" );

                        System.out.println(i+1 + ". "
                                + p.getName() + " - "
                                + category
                                + " - P:" + p.getSmallPrice()
                                + " - M:" + p.getMediumPrice()
                                + " - G:" + p.getLargePrice());
                    }
                    System.out.println("\n\n\n");
                }

                if(index==2){
                    int index2 = 0;
                    while (index2 != 2){
                        try{
                            System.out.println("\n\nCADASTRO DE PRODUTO\n");
                            System.out.print("Nome: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.println("Categoria (1-Pizza, 2-Bebida): ");
                            int category = sc.nextInt();
                            if(category < 1 || category > 2) throw new OutOfIndexBoundsException();
                            System.out.println("Digite os preços do produto nos tamanho Pequeno, Médio e Grande, respectivamente e separados por espaço:");
                            Double small = sc.nextDouble();
                            Double medium = sc.nextDouble();
                            Double big = sc.nextDouble();

                            fmr.addProduct(new Product(name, category, small, medium, big));

                            System.out.println("Cadastro de Produto realizado com sucesso. Deseja adicionar outro? \n1 - Sim\n2 - Retornar ao início");
                            index2 = sc.nextInt();


                        }catch (OutOfIndexBoundsException e){
                            System.out.println("Escolhe um índice entre 1 ou 2.");
                        }

                    }


                }



            }catch (OutOfIndexBoundsException e){
                System.out.println("Escolhe um índice entre 0, 1 ou 2.");
            }

        }

        System.out.println("\n\nGERENCIAMENTO DE PIZZARIAS:");
        index = -1;
        while (index != 0){

            System.out.println("\n1. Selecionar Pizzaria\n");
            System.out.println("2. Adicionar Pizzaria\n\n");


            index = sc.nextInt();

            if(index == 1){
                List<Pizzaria> pizzarias = fpr.getPizzarias();

                for(int i=0; i<pizzarias.size(); i++){
                    Pizzaria p = pizzarias.get(i);

                    System.out.println(i+1 + ". "
                            + p.getName() + " - "
                            + p.getAddress() + " - "
                            + p.getPhone());
                }
                System.out.println("\n\n\n");
                System.out.println("Digite o número do índice da pizzaria desejada: ");
                int index2 = sc.nextInt();
                pizzaria = fpr.getPizzariaByID(index2-1);



                System.out.println("PIZZARIA SELECIONADA!!");
                index = 0;
            }
        }




        System.out.println("\n\n\nGERENCIADOR DE FILIAL");
        System.out.println("Filial " + pizzaria.getName());
        index = -1;

        while (true){
            System.out.println(
                    "\n1. Anotar Pedido" +
                    "\n2. Listar Cardápio" +
                    "\n3. Listar Pedidos" +
                    "\n\n0. Fechar Programa\n\n\n"
            );
            index =sc.nextInt();
            if(index == 1){
                System.out.println("Pedido #"+(pizzaria.getOrders().size()+1)+" :");

                System.out.println("Nome do Cliente: ");
                String name = sc.nextLine();
                System.out.println("Endereço: ");
                String address = sc.nextLine();
                System.out.println("Telefone: ");
                String phone = sc.nextLine();

                Customer customer = new Customer(name, address, phone);


                int index2= -1;
                int i = 0;
                List<ProductForOrder> productsforOrder = new ArrayList<>();

                while (index2 == 1 || index2 == -1){





                    System.out.println("Digite o id do item e seu tamanho (1,2 ou 3 para P,M,G) separados por espaço.");
                    int id = sc.nextInt();
                    int size = sc.nextInt();
                    Double price = null;
                    Product product = fmr.getProductByID(id);
                    if(size == 1) price = product.getSmallPrice();
                    if(size == 2) price = product.getMediumPrice();
                    if(size == 3) price = product.getLargePrice();

                    ProductForOrder productForOrder = new ProductForOrder(product.getName(),price, size);

                    productsforOrder.add(productForOrder);

                    System.out.println("Deseja adicionar outro item? 1. Sim / 2.Não");
                    index2 = sc.nextInt();

                }
                Order order = new Order(productsforOrder, customer);
                makeOrder(pizzaria, order);
                System.out.println("Pedido feito com sucesso!");
            }
            if (index == 2) {
                List<Product> products  =new ArrayList<>();

                products = fmr.getProducts();

                for(int i=0; i<products.size(); i++){
                    Product p = products.get(i);
                    String category = (p.getCategory() == 1) ? "PIZZA" : ((p.getCategory() == 2) ? "BEBIDA" : "NULL" );

                    System.out.println(i+1 + ". "
                            + p.getName() + " - "
                            + category
                            + " - P:" + p.getSmallPrice()
                            + " - M:" + p.getMediumPrice()
                            + " - G:" + p.getLargePrice());
                }
            }
            if (index == 3) {
                for(int i = 0; i<pizzaria.getOrders().size(); i++){
                    System.out.println(i+". " + pizzaria.getOrders().get(i));
                }
            }
            if (index==0) {
                break;
            }
        }










    }
}
