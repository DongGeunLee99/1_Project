import React, { createContext, useState, useContext, useEffect } from 'react';

const ChatContext = createContext();

export const ChatProvider = ({ children }) => {
  const [chatData, setChatData] = useState(() => {
    const saved = localStorage.getItem('chatData');
    return saved ? JSON.parse(saved) : {
      dong: '',
      industry: '',
      pay: ''
    };
  });

  useEffect(() => {
    localStorage.setItem('chatData', JSON.stringify(chatData));
  }, [chatData]);

  const updateChatData = (newData) => {
    setChatData(prev => ({
      ...prev,
      ...newData
    }));
  };

  return (
    <ChatContext.Provider value={{ chatData, updateChatData }}>
      {children}
    </ChatContext.Provider>
  );
};

export const useChat = () => {
  const context = useContext(ChatContext);
  if (!context) {
    throw new Error('useChat must be used within a ChatProvider');
  }
  return context;
};
