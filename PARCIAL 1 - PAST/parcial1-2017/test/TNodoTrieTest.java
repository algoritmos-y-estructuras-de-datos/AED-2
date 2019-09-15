/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joaquin
 */
public class TNodoTrieTest {



    @Test
    public void testBuscarTelefonos() {
        System.out.println("buscarTelefonos");
        String primerosDigitos = "123";
        String codigoArea = "45";
        TArbolTrie trie = new TArbolTrie();
        trie.insertar(new TAbonado("Juan","123456789"));    
        LinkedList<TAbonado> expResult = new LinkedList();
        expResult.add(new TAbonado("Juan","123456789"));
        LinkedList<TAbonado> result = (LinkedList<TAbonado>) trie.buscarTelefonos(primerosDigitos,codigoArea);
        Assert.assertEquals(expResult.getFirst(), result.getFirst());

    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        TArbolTrie trie = new TArbolTrie();
        
        TAbonado unAbonado = new TAbonado("Juan", "123456");
        trie.insertar(unAbonado);
       
        assertEquals(trie.buscarTelefonos("123", "456").size(),1);
        
    }
    
}
