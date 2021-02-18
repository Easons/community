// var data = {a : 1};
// var app = new Vue({
//     el: '#app',
//     data: data
// });

// var data1 = {site: "VueJs", url: "www.runoob.com", alexa: 10000};
// var vm = new Vue({
//     el: '#vue_det',
//     data: data1,
//     data: {
//         message: '<h2>messges</h2>'//添加html代码块
//         , use: true
//         , id: 5
//         ,counter:1
//         , seen: true
//         , url: 'www.baidu.com'
//         , item: 1
//         , filtData: 'string'
//         , sites: [
//
//             {name: 'zhangsan',love:[{ball:'篮球'},{project:'中文'}]},
//             {name: 'lisi',love:[{ball:'排球'},{project:'英文'}]},
//             {name: 'wangwu',love:[{ball:'足球'},{project:'意大利文'}]},
//
//         ],
//         object: {
//             name: 'vue教程',
//             url: 'http://www.baidu.com',
//             slogan: '太阳'
//         }
//     },
//     //添加的方法层
//     methods: {
//         check: function () {
//             alert(vm.$data.item);
//             this.message = vm.$data.message.split('').reverse().join('');//打乱
//         }
//     },
//     filters: {
//         capitalize: function (value) {
//             if (!value) return ''
//             value = value.toString()
//             return value.charAt(0).toUpperCase() + value.slice(1)
//         }
//     },
//     //computed 是基于缓存的，当message的值没有变化时，第二次调用，直接走缓存
//     computed: {
//         // 计算属性的 getter
//         reversedMessage: function () {
//             // `this` 指向 vm 实例
//             return this.message.split('').reverse().join('')
//         },
//         // setter
//         set: function (newValue) {
//             var names = newValue.split(' ')
//             this.name = names[0]
//             this.url = names[names.length - 1]
//         }
//     }
//
// });

// vm.message = 'ahybvh';//改变时，computed计算也会相应的变化计算

// 它们引用相同的对象！
// document.write(vm.site === data.site) // true
// document.write("<br>")
// // 设置属性也会影响到原始数据
// vm.site = "Runoob"
// document.write(data.site + "<br>") // Runoob
//
// // ……反之亦然
// data.alexa = 1234
// document.write(vm.alexa+ "<br>") // 1234

// document.write(data === vm.$data);
// document.write("<br>")

// document.write(vm.$el);
// document.write(document.getElementById('vue_det'));
// document.write("<br>")
// lementById('vue_det'));

// document.write("<br>")
// document.write(vm.$el == document.getE
// document.write(vm.$el === document.getElementById('vue_det')) // true

// vm.site = '菜鸟教程 http://www.runoob.com';
// document.write('name: ' + vm.message);
// document.write('<br>');
// document.write('url: ' + vm.url);

//计算米和千米的方法
// var vm = new Vue({
//     el: '#computed_props',
//     data: {
//         kilometers : 0,
//         meters:0
//     },
//     methods: {
//     },
//     computed :{
//     },
//     watch:{
//
//     },
//     watch : {
//         kilometers:function(val) {
//             alert("kilometers:"+val);
//             this.kilometers = val;
//             this.meters = this.kilometers * 1000
//         },
//         meters : function (val) {
//             alert("meters:"+val);
//             this.kilometers = val/ 1000;
//             this.meters = val;
//         }
//     }
// });
// // $watch 是一个实例方法
// vm.$watch('kilometers', function (newValue, oldValue) {
//     alert("kilometers:oldValue"+oldValue);
//     alert("kilometers:newValue"+newValue);
//     // 这个回调将在 vm.kilometers 改变后调用
//     document.getElementById ("info").innerHTML = "修改前值为: " + oldValue + "，修改后值为: " + newValue;
// });

//样式的定义
// new Vue({
//     el: '#app',
//     data: {
//         isActive: true,
//         error: {
//             value: true,
//             type: 'fatal'
//         }
//     },
//     computed: {
//         classObject: function () {
//             return {
//                 base: true,
//                 active: this.isActive && !this.error.value,
//                 'text-danger': this.error.value && this.error.type === 'fatal',
//             }
//         }
//     }
// });


//事件
// var app = new Vue({
//     el: '#app',
//     data: {
//         name: 'Vue.js'
//     },
//     // 在 `methods` 对象中定义方法
//     methods: {
//         greet: function (event) {
//             // `this` 在方法里指当前 Vue 实例
//             alert('Hello ' + this.name + '!')
//             // `event` 是原生 DOM 事件
//             if (event) {
//                 alert(event.target.tagName)
//             }
//         }
//     }
// });
// // 也可以用 JavaScript 直接调用方法
// // app.greet(); // -> 'Hello Vue.js!'


//全局组件

// 注册全局组件
// Vue.component('runoob', {
//     template: '<h1>自定义组件!</h1>'
// })
//注册局部组件
// var components = {
//     template: '<h5>自定义组件!</h5>'
// };
// var componentel = {
//     template: '<h5>自定义组件EL!</h5>'
// };

// new Vue({
//     el: '#app',
//     data: {
//         message: 'baidu',
//         message2: '百度\r\nhttp://www.baidu.com',
//         checked: false,
//         checkedName:''
//     },
//     methods:{
//         checkOnclick:function (value) {
//             alert(value);
//         }
//     },
//     components:{
//             'runoob' : components,
//             'runoobel' : componentel
//     }
// });

// 注册
// Vue.component('child', {
//     // 声明 props,父组件的数据需要通过 props 把数据传给子组件，子组件需要显式地用 props 选项声明 "prop"：
//     props: ['message'],
//     // 同样也可以在 vm 实例中像 "this.message" 这样使用
//     template: '<span>{{ message }}</span>'
// })

// 创建根实例
// new Vue({
//     el: '#app'
// })

// 注册
// Vue.component('child', {
//     // 声明 props
//     props: ['message'],
//     // 同样也可以在 vm 实例中像 "this.message" 这样使用
//     template: '<span>{{ message }}</span>'
// })
// // 创建根实例
// var vm = new Vue({
//     el: '#app',
//     data: {
//         parentMsg: '父组件内容'
//     }
// });
// vm.$data.parentMsg = '变化的内容';

// Vue.component('child',{
//     props:['todo'],
//     template:'<span>{{ todo.name }}</span>'
//
// })
//
// var vm = new Vue({
//     el: "#app",
//     data: {
//         site: [{
//             name: 'lisi'
//         }, {name: 'wangwu'}, {name: 'zhangsan'}
//         ]
//     }
// });

// Vue.component('button-counter', {
//     template: '<button v-on:click="incrementHandler">{{ counter }}</button>',
//     data: function () {
//         return {
//             counter: 0
//         }
//     },
//     methods: {
//         incrementHandler: function () {
//             this.counter += 1
//             this.$emit('increment')
//         }
//     },
// })
// new Vue({
//     el: '#counter-event-example',
//     data: {
//         total: 0
//     },
//     methods: {
//         incrementTotal: function () {
//             this.total += 1
//         }
//     }
// })

// var buttonCounter2Data = {
//     count: 0
// }
// Vue.component('button-counter2', {
//
//     data: function () {
//         // data 选项是一个函数，组件不相互影响
//         return {
//             count: 0
//         }
//     }
//     /*
//     data: function () {
//         // data 选项是一个对象，会影响到其他实例
//         return buttonCounter2Data
//     }*/,
//     template: '<button v-on:click="count++">点击了 {{ count }} 次。</button>'
// })
// new Vue({ el: '#components-demo3' })


Vue.component('runoob-input', {
    template: `
    <p>   <!-- 包含了名为 input 的事件 -->
      <input
       ref="input"
       :value="value" 
       @input="$emit('input', $event.target.value)"
      >
    </p>
    `,
    props: ['value'], // 名为 value 的 prop
})

new Vue({
    el: '#app',
    data: {
        num: 100,
    }
})
