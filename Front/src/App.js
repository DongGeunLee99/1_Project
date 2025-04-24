import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import MyPage from "./pages/MyPage";
import { AuthProvider } from './contexts/AuthContext';
import { ChatProvider } from './contexts/ChatContext';


function App() {
  return (
    <ChatProvider>
      <AuthProvider>
        <Router>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/mypage" element={<MyPage />} />
          </Routes>
        </Router>
      </AuthProvider>
    </ChatProvider>
  );
}

export default App;