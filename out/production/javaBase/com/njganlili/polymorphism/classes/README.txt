无论向上向下转型，编译看左边，运行看右边

总结一下吧，很多时候，我们需要把很多种类的实例对象，全部扔到一个集合。（这句话很重要）
在这个例子里就是把Thinkpad笔记本，Mouse鼠标，KeyBoard键盘等实例对象，全部扔到一个Shopcar购物车集合。
但是肯定不可能给他们每个种类都用一个独立的集合去存放吧，这个时候我们应该寻找到一个标准，接口就是一个标准。这些都是各种电子产品，抽象成电子产品。然后一个Electronics接口就出来了。
在回到刚才，我们把很多种类的实例对象全部扔到一个集合。或许这样比较好理解：把很多种类的子类实例对象全部扔到存放父类实例的集合。
经过了这个过程，子类实例已经赋值给了父类引用（即完成了向上转型），但很遗憾的丢失了子类扩展的方法。
很好的是Java语言有个向下转型的特性，让我们可以重新获得丢失的方法，即强转回子类 。