import { useEffect, useState } from "react";
import { deleteTodoApi, retrieveAllTodosForUsernameApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

function ListTodosComponent() {

    const today = new Date();

    const authContext = useAuth()

    const username = authContext.username

    const navigate = useNavigate()

    const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay())

    const [todos, setTodos] = useState([])

    const [message, setMessage] = useState(null)

    // const todos = [
    //     // { id: 1, description: 'Learn AWS', done: false, targetDate: targetDate },
    //     // { id: 2, description: 'Learn Full Stack Dev', done: false, targetDate: targetDate },
    //     // { id: 3, description: 'Learn DevOps', done: false, targetDate: targetDate },
    // ]

    useEffect(
        () => refreshTodos()
    )

    function refreshTodos() {

        retrieveAllTodosForUsernameApi(username)
            .then(response => {
                setTodos(response.data)
            }
            )
            .catch(error => console.log(error))

    }


    function deleteTodo(id) {
        console.log('clicked ' + id)
        deleteTodoApi(username, id)
            .then(
                () => {
                    setMessage(`Delete of todo with id = ${id} successful`)
                    refreshTodos()
                }
            )
            .catch(error => console.log(error))
    }


    function updateTodo(id) {
        console.log('clicked ' + id)
        navigate(`/todo/${id}`)
    }



    return (
        <div className="container">
            {message && <div className="alert alert-warning">{message}</div>}
            <h1>Things You Want To Do!</h1>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr key={todo.id}>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        {/* <td>{todo.targetDate.toDateString()}</td> */}
                                        <td>{todo.targetDate.toString()}</td>
                                        <td> <button className="btn btn-warning"
                                            onClick={() => deleteTodo(todo.id)}>Delete</button></td>
                                        <td> <button className="btn btn-success"
                                            onClick={() => updateTodo(todo.id)}>Update</button></td>
                                    </tr>
                                )
                            )
                        }

                    </tbody>

                </table>
            </div>
        </div>
    )
}


export default ListTodosComponent