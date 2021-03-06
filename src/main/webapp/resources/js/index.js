/*
*  set url window.history.pushState("object or string", "Title", "/new-url");
* */
var teacher = null;
var teachers = null;
var users = null;
var lessons = null;
/*--------------------------------------- tabs ----------------------------------*/
var loadTabs = function() {
    loadLessons();
    usersLoad();
    var cnt = document.getElementById('cnt-tabs');
    var cntBodyTabs = cnt.getElementsByTagName("div")[0];
    months = [ 'january', 'february', 'march', 'april', 'may', 'june', 'july', 'august','september', 'october', 'november', 'december'];
    months_rus = ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август','Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'];
    var tabsCount = new Date().getMonth() + 1;
    for (var i = 0; i < tabsCount; ++i) {
        let input = document.createElement("input"),
            label = document.createElement("label");
        $(label).attr('title', months[i]);
        label.appendChild(document.createTextNode(months_rus[i]));
        $(input).attr({
            id: 'tab' + (i + 1),
            type: 'radio',
            name: 'tabs'
        });
        if (!i) {
            $(input).attr('checked', 'checked');
        }
        $(label).attr('for', 'tab' + (i + 1));
        cntBodyTabs.append(input);
        cntBodyTabs.append(label);
    }
    for (var j = 0; j < tabsCount; ++j) {
        var section = document.createElement("section");
        $(section).attr('id', 'content-tab' + (j + 1));
        cntBodyTabs.appendChild(section);
        var elementDivHeader;
        elementDivHeader = $("<div class='cnt-header'></div>").append("<h1>Ведомость учета часов педагогической нагрузки преподователя за <span><span class='month'>"+months_rus[j]+" </span><span class='year'>"+(new Date()).getFullYear()+" год</span></span></h1>").append("<p>" + getFIO() + "</p>");
        var tempId = "content-tab" + (j + 1);
        $("#"+tempId).append(elementDivHeader);
    }
    var elementDivBody = $("<div class='cnt-body'></div>").append("<div class='cnt-table'></div>");
    var elementDivFooter = $("<div class='cnt-footer' id='idCntFooter'></div>").append("<p>Подпись преподователя <span>_____________________</span></p>").append("<p>В последний день месяца заполненый бланк сдается председателю цикловой комиссии для проверки.</p>").append(function() {
        var button = document.createElement("button");
        button.appendChild(document.createTextNode("Сохранить"));
        for (var i = 0; i < 12; ++i) {
            $(button).attr({
                id: 'save' + (i + 1),
                name: 'save' + (i + 1),
                onClick: "saveLessons(this.id.replace('save',''))"
            });
            return button;
        }
    });
    $("section").append(elementDivBody);
    $("section").append(elementDivFooter);
};
/*------------------- table ----------------------*/
var loadTable = function() {
    var tabsCount = new Date().getMonth() + 1;
    for (var k = 0; k < tabsCount; k++) {
        var allTimeInfo = 0;
        var exTimeinThisMonth = 0;
        var container = document.getElementsByClassName('cnt-body')[k];
        var body = container.getElementsByTagName("div")[0];
        var table = document.createElement('table');
        var tblB = document.createElement('tbody');
        var row = 3 + teacher["lessons"].length;
        var collum = 38;
        table.appendChild(tblB);
        for (var i = 0; i < row; i++) {
            var tr = document.createElement('tr');
            tblB.appendChild(tr);
            for (var j = 0; j < collum; j++) {
                var td = document.createElement('td');
                tr.appendChild(td);
                td.classList.add('yesEdit');
                if (i == 0 & j < 1) {
                    td.setAttribute('colspan', '3');
                    td.appendChild(document.createTextNode('Дни недели'));
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                    j += 2;
                }
                if (i == 1 & j < 1) {
                    td.setAttribute('colspan', '3');
                    td.style.background = '#C71585';
                    td.innerHTML = 'Бюджетная форма обучения';
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                    j += 2;
                }
                if (i == row - 1 & j < 1) {
                    td.setAttribute('colspan', '2');
                    td.appendChild(document.createTextNode('Итог по бюджетной форме:'));
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                    j += 1;
                }
                if (i == 0 & j == 3) {
                    td.appendChild(document.createTextNode('Ост.на след.'));
                    td.style.background = '#fff700';
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                }
                /* Следующая неделя не для заполнения */
                if (i == 1 & j == 3) {
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                }
                if (i == 0 & j > 3 & j <= 34) {
                    td.appendChild(document.createTextNode(j - 3));
                    var tema_date = new Date(new Date().getFullYear(), k, j-4);
                    var weekDay = tema_date.getDay() + 1;
                    if (weekDay === 6 || weekDay === 7) {
                        td.style.background = '#FFDAB9';
                    }
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                }
                /* не заполнять */
                if (i == 1 & j > 3 & j <= 34) {
                    td.setAttribute('colspan', '31');
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                    j += 30;
                }
                if (i == 0 & j == collum - 3) {
                    td.setAttribute('colspan', '3');
                    td.appendChild(document.createTextNode('Всего за месяц'));
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                    j += 2;
                }
                /* Не заполнять правый крайний  */
                if (j == collum - 3 | j == collum - 2 | j == collum - 1) {
                    td.style.border = '2px solid #000000';
                }
                if (i == 1 & j == collum - 3) {
                    td.appendChild(document.createTextNode('ч'));
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                }
                if (i == 1 & j == collum - 2) {
                    td.appendChild(document.createTextNode('к'));
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                }
                if (i == 1 & j == collum - 1) {
                    td.appendChild(document.createTextNode('Д/К'));
                    td.classList.add('no-edit');
                    td.classList.remove('yesEdit');
                }
                if (j == 3) {
                    td.style.background = '#fff700';
                }

                if (i > 1 && i < row-1) {
                    /* Название предмета */
                    if (j === 0) {
                        td.appendChild(document.createTextNode(teacher.lessons[i-2].lesson.name));
                    }
                    /* Номер группы */
                    if (j === 1) {
                        var input = document.createElement('input');
                        $(input).attr({
                            type: 'hidden',
                            value: teacher.lessons[i-2].group.id
                        });
                        td.appendChild(document.createTextNode(teacher.lessons[i-2].group.groupNamber));
                        td.appendChild(input);
                    }
                    /* Всего часов */
                    if (j === 2) {
                        allTimeInfo += teacher.lessons[i-2].allTime;
                        td.appendChild(document.createTextNode(teacher.lessons[i-2].allTime));
                    }
                    /* Осталось часов часов */
                    if (j === 3) {
                        var tema_date = new Date(new Date().getFullYear(), k, 5);
                        var lenght = teacher.lessons[i-2].exactTime.length;
                        var ex_time = teacher.lessons[i-2].allTime;
                        for (var month = 0; month < lenght; month++) {
                            var lessonDate = new Date(teacher.lessons[i-2].exactTime[month].date);
                            console.log(tema_date.getMonth());
                            if (lessonDate.getMonth() <= tema_date.getMonth()) {
                                ex_time -= teacher.lessons[i-2].exactTime[month].timeCount;
                            }
                        }
                        exTimeinThisMonth += ex_time;
                        td.appendChild(document.createTextNode(ex_time));
                    }
                    /* Кол-во часов в этот день */
                    if (j < 35 && j > 3) {
                        var tema_date = new Date(new Date().getFullYear(), k, j-3);
                        for (var month = 0; month < teacher.lessons[i-2].exactTime.length; month++) {
                            var lessonDate = new Date(teacher.lessons[i-2].exactTime[month].date);
                            if (tema_date.getMonth() === lessonDate.getMonth()) {
                                console.log("Совпали месяца");
                                if (tema_date.getDate() === lessonDate.getDate()) {
                                    td.appendChild(document.createTextNode(teacher.lessons[i-2].exactTime[month].timeCount));
                                }
                            }
                        }
                        var weekDay = new Date(new Date().getFullYear(), k, j-4).getDay() + 1;
                        if (weekDay === 6 || weekDay === 7) {
                            td.style.background = '#FFDAB9';
                        }
                    }
                    /* ч за месяц */
                    if (j === 35) {
                        td.appendChild(document.createTextNode(''));
                    }
                    /* к за месяц */
                    if (j === 36) {
                        td.appendChild(document.createTextNode(''));
                    }
                    /* д/к за месяц */
                    if (j === 37) {
                        td.appendChild(document.createTextNode(''));
                    }
                }
                if (i === row - 1 && j === 2) {
                    td.appendChild(document.createTextNode(allTimeInfo));
                }
                if (i === row - 1 && j === 3) {
                    td.appendChild(document.createTextNode(exTimeinThisMonth));
                }
            }
        }
        body.appendChild(table);
    }
};
var addIngEditorOnTd = function() {
    $('td.yesEdit').click(function(e) {
        var t = e.target || e.srcElement;
        var elm_name = t.tagName.toLowerCase();
        if (elm_name == 'input') { return false; }
        var val = $(this).html();
        var text = '<input type="text" id="edit" value="' + val + '"/>';
        $(this).empty().append(text);
        $('#edit').focus();
        $('#edit').blur(function() {
            var val = $(this).val();
            $(this).parent().empty().html(val);
        })
    })
};
$(function() {
    teachLoad();
    /*--------- show and hide the menu  ---*/
    $('.button').on("click", function() {
        if ($('body').hasClass('nav_is_visible') == true) {
            $('body').removeClass('nav_is_visible');
            $('.button').removeClass('close');
        } else {
            $('body').addClass('nav_is_visible');
            $('.button').addClass('close');
        }
    });
    $('body').addClass('home_is_visible');

    function removeClasses() {
        $(".menu ul li").each(function() {
            var custom_class = $(this).find('a').data('class');
            $('body').removeClass(custom_class);
        });
    }
    $('.menu a').on('click', function(e) {
        e.preventDefault();
        removeClasses();
        var custom_class = $(this).data('class');
        $('body').addClass(custom_class);
    });

    $(window).keydown(function(event) {
        if (event.keyCode == 13) {
            $('#edit').blur();
        }
    });
    /*---------------------- authorization ---------------------*/
    $(function() {
        const line = document.getElementById('line');
        const rightHandle = document.getElementById('rightHandle');
        const leftHandle = document.getElementById('leftHandle');
        rightHandle.addEventListener('click', (e) => {
            line.classList.remove('left');
            line.classList.add('right');
            if (!e.target.classList.contains('active')) {
                leftHandle.classList.remove('active', 'show');
                $('#cnt-line1').css('display', 'none');
                $('#cnt-line2').css('display', 'block');
                setTimeout(() => {
                    e.target.classList.add('active');
                }, 300);
                setTimeout(() => {
                    e.target.classList.add('show');
                }, 600);
            }
        });
        leftHandle.addEventListener('click', (e) => {
            line.classList.remove('right');
            line.classList.add('left');
            if (!e.target.classList.contains('active')) {
                rightHandle.classList.remove('active', 'show');
                $('#cnt-line1').css('display', 'block');
                $('#cnt-line2').css('display', 'none');
                setTimeout(() => {
                    e.target.classList.add('active');
                }, 300);
                setTimeout(() => {
                    e.target.classList.add('show');
                }, 600);
            }
        });
    });
});
/************* work with teacher *********** */
var getFIO = function () {
    var user = teacher["teacher"];
    return user["surname"] + " " + user["name"].charAt(0).toUpperCase() + "." + user["patronymic"].charAt(0).toUpperCase() + ".";
};

var teachLoad = function () {
    var json = $.getJSON( "json/autchInfo", function() {})
        .done(function() {
            teacher = json["responseJSON"];
            loadTabs();
            loadTable();
            addIngEditorOnTd();
            console.log( "Teacher is load" );
        })
        .fail(function(ex) {
            console.log(ex);
        });
};

var usersLoad = function () {
    var json = $.getJSON( "/admin/json/users", function() {})
        .done(function() {
            users = json["responseJSON"];
            console.log( "Users is load" );
        })
        .fail(function(ex) {
            console.log(ex);
        });
};
var loadLessons = function () {
    var json = $.getJSON( "/admin/json/lessons", function() {})
        .done(function() {
            lessons = json["responseJSON"];
            console.log( "Teacher is load" );
        })
        .fail(function(ex) {
            console.log(ex);
        });
};
var tableToJSON = function (i) {
    var myTableArray = [];
    $("#content-tab"+i).find(" table tr").each(function() {
        var arrayOfThisRow = [];
        var tableData = $(this).find('td');
        if (tableData.length > 0) {
            tableData.each(function() { arrayOfThisRow.push($(this).text()); });
            myTableArray.push(arrayOfThisRow);
        }
    });
    return myTableArray.slice(2);
};

var queryAddTeacherTime = function (tableToJSON, month) {
    var user = teacher.teacher;
    var json = {
        teacher: {
            id: user.id,
            name: user.name,
            surname: user.surname,
            patronymic: user.patronymic,
            roles: user.roles,
            password: user.password,
            mail: user.mail,
            login: user.login
        },
        lessons: getLessons(tableToJSON, month)
    };
    return json;
};

var getLessons = function(tableToJSON, month) {
    var arrayLessons = [];
    for(var i = 0; i < tableToJSON.length; i++) {
        var exTime = [];
        for(var j = 4; j < tableToJSON[i].length; j++) {
            if (tableToJSON[i][j] !== "") {
                exTime[exTime.length]= {
                    id: 0,
                    date: new Date(new Date().getFullYear(),month,j).getTime(),
                    timeCount: parseInt(tableToJSON[i][j]),
                    info: null,
                    teacher_lesson_id: teacher.lessons[i].teacherId
                };
            }
        }
        var lesson = {
            id: 3,
            teacherId: teacher.teacher.id,
            lesson: {
                id: 0,
                name: tableToJSON[i][0]
            },
            group: {
                id: 0,
                name: tableToJSON[i][1]
            },
            allTime: tableToJSON[i][2],
            exactTime: exTime
        };
        arrayLessons[arrayLessons.length] = lesson;
    }
    return arrayLessons;
};

var saveLessons = function (month) {
    var teacher = queryAddTeacherTime(tableToJSON(parseInt(month)), parseInt(month));
    console.log(teacher);
    console.log(JSON.stringify(teacher));
    var json = $.get( "/teacher/json/saveInfo?teacher="+encodeURIComponent(JSON.stringify(teacher)), function() {})
        .done(function() {
            console.log( "Teacher is load" );
        })
        .fail(function(ex) {
            console.log(ex);
        });
};
/*------------------------------------------- adminPanel ---------------------------------*/
$(function() {
    var adminPanelCnt = document.getElementById('id-adminPanel');
    var adminPanelTags = adminPanelCnt.getElementsByTagName('div')[1];
    var textElement = ['Работа с пользователями', 'Работа с предметами', 'Работа с группами'];
    var nameElement = ['Work_with_users', 'Working_with_objects', 'Working_with_groups'];
    for (var i = 2; i >= 0; --i) {
        let input = document.createElement("input"),
            label = document.createElement("label");
        $(label).attr('title', nameElement[i]);
        label.append(document.createTextNode(textElement[i]));
        $(input).attr({
            id: 'adminTabs' + (i),
            type: 'radio',
            name: 'adminTabs'
        });
        if (!i) {
            $(input).attr('checked', 'checked');
        }
        $(label).attr('for', 'adminTabs' + (i));
        adminPanelTags.prepend(label);
        adminPanelTags.prepend(input);
    }});
var adminWok = function() {
    new Vue({
        el: '#app',
        data: {
            searchValue: '',
            row: {}
        },
        methods: {
            del(index) {
                this.row.data.splice(index, 1)
                console.log({
                    'id': index
                })
            },
            save(index) {
                console.log('hello')
                console.log(this.row.data[index])
                let result = {}
                for (let i = 0; i < this.row.data[index].length; i++) {
                    result = this.row.data[index].map(item => {
                        return { 'value': item.value }
                    })
                }
                console.log(result)
            },
            add() {
                this.row.data.push(
                    [{ value: 'text', state: false }, { value: 'text', state: false }, { value: 'text', state: false }, { value: 'text', state: false }, { value: 'text', state: false }, { value: 'text', state: false }, { value: 'text', state: false }])
            },
            search() {
                for (let i = 0; i < this.row.data.length; i++) {
                    let resultSearch = []
                    for (let index = 0; index < this.row.data[i].length; index++) {
                        if (this.row.data[i][index].value == this.searchValue) {
                            resultSearch.push(this.row.data[i])
                        }
                        this.row.data = resultSearch
                    }
                    console.log(resultSearch)
                }
            },
            remove() {
                console.log(this.row);
                for (let i = 0; i < this.row.data.length; i++) {
                    for (let index = 0; index < this.row.data[i].length; index++) {
                        this.row.data[i][index].state = false;
                    }
                }
            }
        },
        created() {
            if (users != null) {
                var array = [];
                for(var i = 0; i < users.length; i++) {
                    array[array.length] = [
                        {value: users[i].name},
                        {value: users[i].surname},
                        {value: users[i].patronymic},
                        {value: users[i].mail},
                        {value: users[i].login},
                        {value: ""},
                        {value: users[i].roles[0].name}
                    ]
                }
                let req = {
                    data: array
                }
                for (let i = 0; i < req.data.length; i++) {
                    for (let index = 0; index < req.data[i].length; index++) {
                        req.data[i][index].state = false;
                    }
                }
                this.row = req;
            }
        }
    })
    new Vue({
        el: '#app-2',
        data: {
            searchValue: '',
            row: {}
        },
        methods: {
            del(index) {
                this.row.data.splice(index, 1)
                console.log({
                    'id': index
                })
            },
            save(index) {
                console.log('hello')
                console.log(this.row.data[index])
                let result = {}
                for (let i = 0; i < this.row.data[index].length; i++) {
                    result = this.row.data[index].map(item => {
                        return { 'value': item.value }
                    })
                }
                console.log(result)
            },
            add() {
                this.row.data.push(
                    [{ value: 'text', state: false }, { value: 'text', state: false }])
            },
            search() {
                for (let i = 0; i < this.row.data.length; i++) {
                    let resultSearch = []
                    for (let index = 0; index < this.row.data[i].length; index++) {
                        if (this.row.data[i][index].value == this.searchValue) {
                            resultSearch.push(this.row.data[i])
                        }
                        this.row.data = resultSearch
                    }
                    console.log(resultSearch)
                }
            },
            remove() {
                console.log(this.row)
                for (let i = 0; i < this.row.data.length; i++) {
                    for (let index = 0; index < this.row.data[i].length; index++) {
                        this.row.data[i][index].state = false;
                    }
                }
            }
        },
        created() {
            var arr = [];
            if (lessons !== null) {
                for (var i = 0; i < lessons.length; i++) {
                    arr[arr.length] = [
                        {value: lessons[i].name}
                    ]
                }
                let req = {
                    data: arr
                }
                for (let i = 0; i < req.data.length; i++) {
                    for (let index = 0; index < req.data[i].length; index++) {
                        req.data[i][index].state = false;
                    }
                }
                this.row = req;
            }
        }
    });
    new Vue({
        el: '#app-3',
        data: {
            searchValue: '',
            row: {}
        },
        methods: {
            del(index) {
                this.row.data.splice(index, 1)
                console.log({
                    'id': index
                })
            },
            save(index) {
                console.log('hello')
                console.log(this.row.data[index])
                let result = {}
                for (let i = 0; i < this.row.data[index].length; i++) {
                    result = this.row.data[index].map(item => {
                        return { 'value': item.value }
                    })
                }
                console.log(result)
            },
            add() {
                this.row.data.push(
                    [{ value: 'text', state: false }, { value: 'text', state: false }])
            },
            search() {
                for (let i = 0; i < this.row.data.length; i++) {
                    let resultSearch = []
                    for (let index = 0; index < this.row.data[i].length; index++) {
                        if (this.row.data[i][index].value == this.searchValue) {
                            resultSearch.push(this.row.data[i])
                        }
                        this.row.data = resultSearch
                    }
                    console.log(resultSearch)
                }
            },
            remove() {
                console.log(this.row)
                for (let i = 0; i < this.row.data.length; i++) {
                    for (let index = 0; index < this.row.data[i].length; index++) {
                        this.row.data[i][index].state = false;
                    }
                }
            }
        },
        created() {
            let req = {
                data: [
                    [{ value: 'text' }, { value: 'text' }],
                    [{ value: 'text' }, { value: 'text' }],
                    [{ value: 'text' }, { value: 'text' }]
                ]
            }
            for (let i = 0; i < req.data.length; i++) {
                for (let index = 0; index < req.data[i].length; index++) {
                    req.data[i][index].state = false;
                }
            }
            this.row = req;
        }
    });
};

var intId = setInterval(allIsLoad, 500);
function allIsLoad() {
    if(users!==null && lessons != null) {
        clearInterval(intId);
        adminWok();
    }
}