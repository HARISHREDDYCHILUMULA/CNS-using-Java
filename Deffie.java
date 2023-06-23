import java.io.*;
import java.util.Scanner;
public class DHKE{
public static void main(String[] args){
int q,alpha_picked,xa,xb,ya,yb,ka,kb,index=0;
int alpha [] =new int[100];
System.out.println("Enter the prime : ");
Scanner sc=new Scanner(System.in);
q=sc.nextInt();
for(int i=2;i<q;i++){
int alpharnot[]=new int[q];
for (int j=1;j<=q;j++){
alpharnot[j-1]=(int)((java.lang.Math.pow(i,j))%q);
int c=0;
for(int k=0;k<q;k++){
for(int p=k+1;p<q;p++){
if(alpharnot[k]==alpharnot[p]){c++;}			
}		
}
if(c==0){
alpha[index]=i;index++;			
}		
}	
}
for(int i=0;i<index;i++){
System.out.println("Primitive root is  : "+ alpha[i]);	
}
System.out.println("Select one of the root : ");
alpha_picked=sc.nextInt();
System.out.println("Select  Xa: ");
xa=sc.nextInt();
System.out.println("Select  Xb: ");
xb=sc.nextInt();
ya=(int)((java.lang.Math.pow(alpha_picked,xa))%q);
yb=(int)((java.lang.Math.pow(alpha_picked,xb))%q);
ka=(int)((java.lang.Math.pow(yb,xa))%q);
kb=(int)((java.lang.Math.pow(ya,xb))%q);
System.out.println("Ka: "+ka+" Kb :"+kb);
if(ka==kb){
System.out.println("Keys are same");
}
}
}
/*

#include <stdio.h>
#include <math.h>

// Function to calculate the power modulo of a number
int powerModulo(int base, int exponent, int modulus) {
    long long result = 1;
    while (exponent > 0) {
        if (exponent % 2 == 1) {
            result = (result * base) % modulus;
        }
        base = (base * base) % modulus;
        exponent = exponent / 2;
    }
    return (int)result;
}

int main() {
    int p, g, a, b;

    printf("Enter the prime number (p): ");
    scanf("%d", &p);

    printf("Enter the primitive root (g): ");
    scanf("%d", &g);

    printf("Enter the private key for person A (a): ");
    scanf("%d", &a);

    printf("Enter the private key for person B (b): ");
    scanf("%d", &b);

    // Calculate public keys for person A and B
    int A = powerModulo(g, a, p);
    int B = powerModulo(g, b, p);

    // Calculate the shared secret key for person A and B
    int secretKeyA = powerModulo(B, a, p);
    int secretKeyB = powerModulo(A, b, p);

    printf("Public key for person A: %d\n", A);
    printf("Public key for person B: %d\n", B);
    printf("Shared secret key for person A: %d\n", secretKeyA);
    printf("Shared secret key for person B: %d\n", secretKeyB);

    return 0;
  }

*/
