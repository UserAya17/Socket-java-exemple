package Serveur;

//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Serveur {
//
//	public static int calculateFactorial(int n) {
//        if (n < 0) {
//            throw new IllegalArgumentException("Le nombre doit être positif ou nul.");
//        }
//        int factorial = 1;
//        for (int i = 2; i <= n; i++) {
//            factorial *= i;
//        }
//        return factorial;
//    }
//	
//	public static void main(String[] args) throws Exception
//	{
//	ServerSocket ss =new ServerSocket (1234);
//	System.out.println("j'attend cnx de client");
//	Socket so = ss.accept();
//	InputStream is = so.getInputStream();
//	OutputStream os = so.getOutputStream();
//	int nb =is.read();
//	System.out.println("je lis");
//	int res=calculateFactorial(nb);
//	os.write(res);
//	so.close();
//
//	}
//	
//}


//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Serveur {
//
//    public static void main(String[] args) throws Exception {
//        ServerSocket ss = new ServerSocket(1234);
//        System.out.println("J'attends connexion de client");
//        Socket so = ss.accept();
//
//        InputStream is = so.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        String chaine = br.readLine();
//        System.out.println("Le client dit : " + chaine);
//
//        so.close();
//
//    }
//}


//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import Objet.Compte;
//
//public class Serveur {
//
//    public static void main(String[] args) throws Exception {
//        ServerSocket ss = new ServerSocket(1234);
//        System.out.println("J'attends connexion de client");
//        Socket so = ss.accept();
//
//        InputStream is = so.getInputStream();
//        ObjectInputStream iss = new ObjectInputStream(is);
//        Compte v = (Compte) iss.readObject();
//        so.close();
//    }
//}

//
//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.OutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import Objet.Compte;
//
//public class Serveur {
//
//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		ServerSocket ss=new ServerSocket(1234);
//		
//		System.out.println("je suis le serveur j'attend une connexion");
//		Socket so=ss.accept();
//		
//		InputStream is=so.getInputStream();
//		ObjectInputStream objectInputStream = new ObjectInputStream(is);
//        Compte cm=(Compte) objectInputStream.readObject();
//		System.out.println("le compte envoye est : "+ cm);
//		
//		OutputStream os=so.getOutputStream();
//		ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
//		objectOutputStream.writeObject(cm);
//		
//	}
//}
//


//
//
//import java.net.*;
//import java.io.*;
//
//public class Serveur {
//    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(1234);
//        while (true) {
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("Serveur : Un client connecte: " + clientSocket);
//
//            Thread t = new Thread(new ClientHandler(clientSocket));
//            t.start();
//        }
//    }
//
//    static class ClientHandler implements Runnable {
//        private Socket clientSocket;
//
//        public ClientHandler(Socket socket) {
//            this.clientSocket = socket;
//        }
//
//        public void run() {
//            try {
//                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                String message = in.readLine();
//                System.out.println("Serveur : Client message: " + message);
//                // Réponse au client
//                out.println("J'ai recue ce message " + message);
//                in.close();
//                out.close();
//                clientSocket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}


import java.io.*;
import java.net.*;
import Objet.Compte; // Importation de la classe Compte depuis le package Objet

public class Serveur {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Création d'un ServerSocket écoutant sur le port 1234
        ServerSocket ss = new ServerSocket(1234);
        
        System.out.println("Je suis le serveur, j'attends une connexion"); // Message indiquant que le serveur est en attente de connexion
        
        // Acceptation de la connexion entrante du client
        Socket so = ss.accept();
        
        // Flux d'entrée pour recevoir les données envoyées par le client
        InputStream is = so.getInputStream();
        // Création d'un ObjectInputStream pour désérialiser les objets reçus
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        // Lecture de l'objet Compte envoyé par le client
        Compte cm = (Compte) objectInputStream.readObject();
        // Affichage du compte reçu du client
        System.out.println("Le compte envoyé est : " + cm);
        
        // Flux de sortie pour envoyer des données au client
        OutputStream os = so.getOutputStream();
        // Création d'un ObjectOutputStream pour sérialiser les objets à envoyer
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        // Envoi de l'objet Compte reçu du client
        objectOutputStream.writeObject(cm);
        
        // Fermeture de la connexion avec le client
        so.close();
    }
}





