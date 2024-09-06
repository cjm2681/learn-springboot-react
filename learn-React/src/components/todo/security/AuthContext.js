import { createContext, useContext, useState } from "react";


//1: Create a Context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)    //다른 컴포넌트에서 간편하게 사용하기 위해 작성

//2: Share the created context with other components
export default function AuthProvider({children}) {

    //3: Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false)


    function login(username, password) {
        if (username === "in28minutes" && password === "123") {
            setAuthenticated(true)
            return true
        } else {
            setAuthenticated(false)
            return false
        }

    }

    function logout() {
        setAuthenticated(false)
    } 


    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
            {children}
        </AuthContext.Provider>
    )
}