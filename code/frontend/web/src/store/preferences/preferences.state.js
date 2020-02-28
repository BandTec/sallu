// =============================================================================
// Initial State
// =============================================================================

const preferencesState = JSON.parse(
  localStorage.getItem('preferences') 
) || {
  theme: 'light'
}

// const preferencesState = {
//   theme: 'light',
// }

export default preferencesState;