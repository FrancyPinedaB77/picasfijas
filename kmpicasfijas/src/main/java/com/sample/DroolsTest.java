package com.sample;

import org.drools.KnowledgeBase;
import java.util.Random;
import java.util.Scanner;

import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.Color;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
    	try {
    	//load up the knowledge base
        KnowledgeBase kbase = readKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
        // go !
    	int numeros[]=new int[4];
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero "));
        JOptionPane.showMessageDialog(null, n);//cuando finaliza el ciclo se muestra el mensaje.
        
        System.out.println("el numero n es:");
        System.out.println(n);
                
        int n1,n2,n3,n4;
        n1=(n-(n%1000))/1000;
        n2=((n-(n1*1000))-(n-n1*1000)%100)/100;
        n3=(((n-(n1*1000+n2*100)))-(((n-(n1*1000+n2*100)))%10))/10;
        		//-(n-(n1*1000+n2*100)%10))/10;
        n4=n-(n1*1000+n2*100+n3*10);

        numeros[0]=n1;
        numeros[1]=n2;
        numeros[2]=n3;
        numeros[3]=n4;
        System.out.println(numeros[0]);
        System.out.println(numeros[1]);
        System.out.println(numeros[2]);
        System.out.println(numeros[3]);
        
        /*
        int aux=0;
        int correcto=1;
        for (int i=0;i<4;i++)
        {
        	if ( numeros[i] == numeros[i+1] ) 
        	{
        		aux++;
        		if (aux!=0){
        			correcto=0;
                	System.out.println(correcto);
                }
        	}
        }
        */
        
		//if (correcto==0){
        //	System.out.println("entra a ala condicion");
        //	n = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero "));
        //}
        //try {
            // load up the knowledge base
            //KnowledgeBase kbase = readKnowledgeBase();
            //StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            //KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            ksession.insert(message);
            ksession.fireAllRules();
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;
        public static int n = 1234;
        public static int numero_adivinar= 1234;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }
    
    public static class Loquellega {

        int n = 1234;
        int numero_adivinar= 1234;


    }
    
    
    private static void inicializar ()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 0; j++)
			{
				System.out.println("Entro al for ");
			}
		}
	}
    
}
