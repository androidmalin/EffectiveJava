package concurrency;

// {Exec: javap -c Atomicity}
public class Atomicity {
    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}

/* Output: (Sample)

public class concurrency.Atomicity {
  int i;

  public concurrency.Atomicity();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  void f1();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return

  void f2();
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field i:I
       5: iconst_3
       6: iadd
       7: putfield      #2                  // Field i:I
      10: return
}
*/
