package org.example;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.VoidVisitorWithDefaults;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


// This class visits a compilation unit and
// prints in a file all the private fields without a getter
public class PublicElementsPrinter extends VoidVisitorWithDefaults<Void> {

    private ArrayList<String> fieldList = new ArrayList<String>();
    private int testNoGetterTrue = 1;
    public int tesNoGetterFalse;

    @Override
    public void visit(CompilationUnit unit, Void arg) {
        for(TypeDeclaration<?> type : unit.getTypes()) {
            type.accept(this, null);
        }
    }

    public void visitTypeDeclaration(TypeDeclaration<?> declaration, Void arg) {
        if(!declaration.isPublic()) return;
        //System.out.println(declaration.getFullyQualifiedName().orElse("[Anonymous]"));
        for(MethodDeclaration method : declaration.getMethods()) {
            method.accept(this, arg);
        }
        // Printing nested types in the top level
        for(BodyDeclaration<?> member : declaration.getMembers()) {
            if (member instanceof TypeDeclaration)
                member.accept(this, arg);
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration declaration, Void arg) {
        visitTypeDeclaration(declaration, arg);
    }

    @Override
    public void visit(EnumDeclaration declaration, Void arg) {
        visitTypeDeclaration(declaration, arg);
    }

    @Override
    public void visit(FieldDeclaration declaration, Void arg) {
        if(!declaration.isPrivate()) return;
        for (VariableDeclarator var : declaration.getVariables()) {
            fieldList.add(var.getNameAsString());
        }
    }

    @Override
    public void visit(MethodDeclaration declaration, Void arg) {
        if(!declaration.isPublic()) return;
        String methodName = declaration.getNameAsString();
        if (methodName.contains("get")){
            String fieldName = methodName.substring(3);
            if (fieldList.contains(fieldName)){
                fieldList.remove(fieldName);
            }
            System.out.println("  " + fieldName);
        }

    }

    public ArrayList<String> getFieldList(){
        return fieldList;
    }

    public void createFile() throws FileNotFoundException, UnsupportedEncodingException {
        List<String> to_write = getFieldList();

        PrintWriter writer = new PrintWriter("no_getter.txt", "UTF-8");
        writer.println("Arrtibuts sans getter :\n");
        for (String line : to_write) {
            writer.println(line);
        }
        writer.close();
    }

}
