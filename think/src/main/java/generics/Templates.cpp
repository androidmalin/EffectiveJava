#include <iostream>
using namespace std;

template<class T> class Manipulator {
    T obj;
    public: Manipulator(T x) {
          obj = x;
      }
      void manipulate() {
          obj.f();
      }
};

class HasF {
    public: void f() {
          cout << "HasF::f()" << endl;
      }
};

/**clang++ -Wall -g -std=c++11 -stdlib=libc++ Templates.cpp -o Templates**/
int main() {
      HasF hf;
      Manipulator<HasF> manipulator(hf);
      manipulator.manipulate();
}
