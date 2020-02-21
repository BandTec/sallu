import React from 'react';

import ThemeProvider from './providers/themeProvider';
import GlobalStyles from './styles/global';
import { Routes } from './configs/routes';

const App = () => (
  <ThemeProvider>
    <GlobalStyles />
    <Routes />
  </ThemeProvider>
);

export default App;
