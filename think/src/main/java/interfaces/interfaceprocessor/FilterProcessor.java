package interfaces.interfaceprocessor;

import interfaces.filters.BandPass;
import interfaces.filters.Filter;
import interfaces.filters.HighPass;
import interfaces.filters.LowPass;
import interfaces.filters.Waveform;


/**
 * 你经常碰到的情况是你无法修改你想要使用的类。
 * <p>
 * 例如，在电子滤波器的例子中，类库是被发现而非被创建的。
 * <p>
 * 在这些情况下，可以使用适配器设计模式。
 * <p>
 * 适配器中的代码将接受你所拥有的接囗，并产生你所需要的接囗，
 * 就像下面这样：
 * <p>
 * 在这种使用适配器的方式中，FilterAdapter的构造器接受你所拥有的接囗Filter，
 * 然后生成具有你所需要的Processor接囗的对象。
 * <p>
 * 你可能还注意到了，在FilterAdapter类中用到了代理。
 * 将接囗从具体实现中解耦, 使得接囗可以应用于多种不同的具体实现，
 * 因此代码也就更具可复用性。
 */
class FilterAdapter implements Processor {
    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}

/**
 * 重点关注
 */
public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(
                new FilterAdapter(new BandPass(3.0, 4.0)),
                w
        );
    }
}
