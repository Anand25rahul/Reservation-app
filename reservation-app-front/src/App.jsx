import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes ,Route} from 'react-router-dom';
import LandingPage from './Components/LandingPage';
import AdminLogin from './Components/AdminLogin';
import UserLogin from './Components/UserLogin';

function App() {
    return(
        <div className="app">
            <BrowserRouter>
            <Routes>
                <Route path='/' element={<LandingPage/>}/>
                <Route path='/' element={<AdminLogin/>}/>
                <Route path='/' element={<UserLogin/>}/>
            </Routes>
            </BrowserRouter>
        </div>
    )
}
export default App