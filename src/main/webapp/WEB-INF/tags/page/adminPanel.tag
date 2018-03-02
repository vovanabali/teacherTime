<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/page" %>
<div class='content adminPanel'>
    <div class="wrapper">
        <div class="cnt-adminPanel" id="id-adminPanel">
            <div class='cnt-header'>
                <h1> Админ панель </h1></div>
            <div class='cnt-body'>
                <div id="cnt-adminTabs0">
                    <div id="app">
                        <button class="btn-class-adminSection" @click="add">Добавить нового пользователя</button>
                        <table class="table_blur" id="idTable_blur">
                            <tr>
                                <th>#</th>
                                <th>Имя</th>
                                <th>Фамилия</th>
                                <th>Отчество</th>
                                <th>E-mail</th>
                                <th>Login</th>
                                <th>Password</th>
                                <th>Роль</th>
                                <th>Save</th>
                                <th>Remove</th>
                            </tr>
                            <tr v-for="(item,index) in row.data">
                                <td>{{ index }}</td>
                                <td v-for="i in item">
                                    <span v-if="!i.state" @click="remove(); i.state = true">{{ i.value }}</span>
                                    <input type="text" v-model="i.value" v-else></input>
                                </td>
                                <td>
                                    <a class="button tick" @click="save(index)"></a>
                                </td>
                                <td>
                                    <a class="button cross" @click="del(index)"></a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div id="cnt-adminTabs1">
                    <div id="app-2">
                        <button class="btn-class-adminSection" @click="add">Добавить новый предмет</button>
                        <table class="table_blur" id="idTable_blur">
                            <tr>
                                <th>№</th>
                                <th>Название предмета</th>
                                <th>Save</th>
                                <th>Remove</th>
                            </tr>
                            <tr v-for="(item,index) in row.data">
                                <td>{{ index }}</td>
                                <td v-for="i in item">
                                    <span v-if="!i.state" @click="remove(); i.state = true">{{ i.value }}</span>
                                    <input type="text" v-model="i.value" v-else></input>
                                </td>
                                <td>
                                    <a class="button tick" @click="save(index)"></a>
                                </td>
                                <td>
                                    <a class="button cross" @click="del(index)"></a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div id="cnt-adminTabs2">
                    <div id="app-3">
                        <button class="btn-class-adminSection" @click="add">Добавить новую группу</button>
                        <table class="table_blur" id="idTable_blur">
                            <tr>
                                <th>№</th>
                                <th>Название группы</th>
                                <th>Save</th>
                                <th>Remove</th>
                            </tr>
                            <tr v-for="(item,index) in row.data">
                                <td>{{ index }}</td>
                                <td v-for="i in item">
                                    <span v-if="!i.state" @click="remove(); i.state = true">{{ i.value }}</span>
                                    <input type="text" v-model="i.value" v-else></input>
                                </td>
                                <td>
                                    <a class="button tick" @click="save(index)"></a>
                                </td>
                                <td>
                                    <a class="button cross" @click="del(index)"></a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>