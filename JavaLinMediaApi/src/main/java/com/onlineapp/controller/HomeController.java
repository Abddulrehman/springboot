package com.onlineapp.controller;
//package com.onlineapp.onlineapp.controller;
//
//import io.javalin.Javalin;
//import io.javalin.Javalin;
//import io.javalin.http.Context;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.apache.tomcat.util.descriptor.web.ContextHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.onlineapp.onlineapp.models.Account;
//
//import java.util.List;
//public class HomeController {
//
//	 private static EntityManagerFactory entityManagerFactory;
//	 public static void main(String[] args) {
//	        Javalin app = Javalin.create().start(7000);
//	        
//	        
//	        Account acc=new Account();
//	        app.get("/", ctx -> ctx.result("Hello, Javalin!"));
//
//	       
//	         // Create EntityManagerFactory
//	         entityManagerFactory = Persistence.createEntityManagerFactory("");
//
//	         // Define routes
//	         app.get("/", ctx -> ctx.result("Welcome to the Javalin CRUD Application"));
//	         app.get("/products", acc);
//	         app.get("/products/:id", getProductById);
//	         app.post("/products", createProduct);
//	         app.put("/products/:id", updateProduct);
//	         app.delete("/products/:id", deleteProduct);
//
//	         // Stop EntityManagerFactory when the app shuts down
//	         app.events(event -> event.serverStopped(() -> entityManagerFactory.close()));
//	     }
//
//	     private static ContextHandler getAllProducts = ctx -> {
//	         EntityManager entityManager = entityManagerFactory.createEntityManager();
//	         entityManager.getTransaction().begin();
//	         List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
//	         entityManager.getTransaction().commit();
//	         entityManager.close();
//	         ctx.json(products);
//	     };
//
//	     private static ContextHandler getProductById = ctx -> {
//	         long productId = ctx.pathParam("id", Long.class).get();
//	         EntityManager entityManager = entityManagerFactory.createEntityManager();
//	         entityManager.getTransaction().begin();
//	         Product product = entityManager.find(Product.class, productId);
//	         entityManager.getTransaction().commit();
//	         entityManager.close();
//	         if (product != null) {
//	             ctx.json(product);
//	         } else {
//	             ctx.status(404).result("Product not found");
//	         }
//	     };
//
//	     private static ContextHandler createProduct = ctx -> {
//	         Product product = ctx.bodyAsClass(Product.class);
//	         EntityManager entityManager = entityManagerFactory.createEntityManager();
//	         entityManager.getTransaction().begin();
//	         entityManager.persist(product);
//	         entityManager.getTransaction().commit();
//	         entityManager.close();
//	         ctx.status(201).result("Product created");
//	     };
//
//	     private static ContextHandler updateProduct =updateProject() {
//	         long productId = ctx.pathParam("id", Long.class).get();
//	         Product updatedProduct = ctx.bodyAsClass(Product.class);
//	         EntityManager entityManager = entityManagerFactory.createEntityManager();
//	         entityManager.getTransaction().begin();
//	         Product existingProduct = entityManager.find(Product.class, productId);
//	         if (existingProduct != null) {
//	             existingProduct.setName(updatedProduct.getName());
//	             existingProduct.setPrice(updatedProduct.getPrice());
//	             entityManager.getTransaction().commit();
//	             ctx.status(200).result("Product updated");
//	         } else {
//	             entityManager.getTransaction().rollback();
//	             ctx.status(404).result("Product not found");
//	         }
//	         entityManager.close();
//	     };
//
//	     private static ContextHandler deleteProduct = ctx -> {
//	         long productId = ctx.pathParam("id", Long.class).get();
//	         EntityManager entityManager = entityManagerFactory.createEntityManager();
//	         entityManager.getTransaction().begin();
//	         Product product = entityManager.find(Product.class, productId);
//	         if (product != null) {
//	             entityManager.remove(product);
//	             entityManager.getTransaction().commit();
//	             ctx.status(200).result("Product deleted");
//	         } else {
//	             entityManager.getTransaction().rollback();
//	             ctx.status(404).result("Product not found");
//	         }
//	         entityManager.close();
//	     };
//	 }
//
//}
