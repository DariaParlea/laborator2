package org.example;
import org.example.repositories.*;
import org.example.controllers.*;

public class Main {
    public static void main(String[] args) {
        AuthorRepository authorRepository = new AuthorRepository();
        BooksRepository booksRepository = new BooksRepository();
        CartItemRepository cartItemRepository = new CartItemRepository();
        CategoryRepository categoryRepository = new CategoryRepository();
        ClientsRepository clientsRepository = new ClientsRepository();
        OrdersRepository ordersRepository = new OrdersRepository();
        PaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();
        PublisherRepository publisherRepository = new PublisherRepository();
        ReviewRepository reviewRepository = new ReviewRepository();
        ShippingRepository shippingRepository = new ShippingRepository();

        AuthorController authorController = new AuthorController(authorRepository);
        BookController bookController = new BookController(booksRepository);
        CartController cartController = new CartController(cartItemRepository);
        CategoryController categoryController = new CategoryController(categoryRepository);
        ClientController clientController = new ClientController(clientsRepository);
        OrdersController ordersController = new OrdersController(ordersRepository);
        PaymentMethodController paymentMethodController = new PaymentMethodController(paymentMethodRepository);
        PublisherController publisherController = new PublisherController(publisherRepository);
        ReviewController reviewController = new ReviewController(reviewRepository);
        ShippingController shippingController = new ShippingController(shippingRepository);

        ClientUI clientUI = new ClientUI(bookController,ordersController,clientController,cartController,reviewController,paymentMethodController, categoryController,authorController, shippingController);
        //clientUI.start();

        ManagerUI managerUI = new ManagerUI(authorController,bookController,categoryController,ordersController,publisherController,shippingController,clientController,reviewController,paymentMethodController);
        managerUI.start();
    }
}