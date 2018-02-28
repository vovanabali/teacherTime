$(function() {
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
    /*--------------------------------------- tabs ----------------------------------*/
    $(function() {
        var cnt = document.getElementById('cnt-tabs');
        var cntBodyTabs = cnt.getElementsByTagName("div")[0];
        months = ['january', 'february', 'march', 'april', 'may', 'june', 'july', 'august', 'september', 'october', 'november', 'december'];
        months_rus = ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь', 'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'];
        for (var i = 0; i < 12; ++i) {
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
        for (var j = 0; j < 12; ++j) {
            var section = document.createElement("section");
            $(section).attr('id', 'content-tab' + (j + 1));
            cntBodyTabs.appendChild(section);
        }
        var elementDivHeader = $("<div class='cnt-header'></div>").append("<h1>Ведомость учета часов педагогической нагрузки преподователя за<span><span class='month'> ________ </span><span class='year'>____ год</span></span></h1>").append("<p>Красоткина А.Н.</p>");
        var elementDivBody = $("<div class='cnt-body'></div>").append("<div class='cnt-table'></div>");
        var elementDivFooter = $("<div class='cnt-footer' id='idCntFooter'></div>").append("<p>Подпись преподователя <span>_____________________</span></p>").append("<p>В последний день месяца заполненый бланк сдается председателю цикловой комиссии для проверки.</p>").append(function() {
            var button = document.createElement("button");
            button.appendChild(document.createTextNode("Сохранить"));
            for (var i = 0; i < 12; ++i) {
                $(button).attr({
                    id: 'save' + (i + 1),
                    name: 'save' + (i + 1),
                });
                return button;
            }
        });
        $("section").append(elementDivHeader);
        $("section").append(elementDivBody);
        $("section").append(elementDivFooter);
    });
    /*------------------- table ----------------------*/
    $(function() {
        for (var k = 0; k < 12; k++) {
            var container = document.getElementsByClassName('cnt-body')[k];
            var body = container.getElementsByTagName("div")[0];
            var table = document.createElement('table');
            var tblB = document.createElement('tbody');
            var row = 24;
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
                        td.style.background = '#FFDAB9';
                        td.classList.add('no-edit');
                        td.classList.remove('yesEdit');
                    }
                    if (i == 1 & j == 3) {
                        td.classList.add('no-edit');
                        td.classList.remove('yesEdit');
                    }
                    if (i == 0 & j > 3 & j <= 34) {
                        td.appendChild(document.createTextNode(j - 3));
                        td.classList.add('no-edit');
                        td.classList.remove('yesEdit');
                    }
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
                        td.style.background = '#FFDAB9';
                    }
                }
            }
            body.appendChild(table);
        }
    });
    $(function() {
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