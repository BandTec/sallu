import React from 'react';

import ThemeProvider from './providers/themeProvider';
import { ContextProvider } from './providers/contextProvider';
import GlobalStyles from './styles/global';
import { Routes } from './configs/routes';

const App = () => (
  <ThemeProvider>
    <ContextProvider>
      <GlobalStyles />
      <Routes />
    </ContextProvider>
  </ThemeProvider>
);

export default App;
